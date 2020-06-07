const crypto = require('crypto');
const uuid = require('uuid');
const express = require('express');
const mysql = require('mysql');
const bodyParser = require('body-parser');
const PORT = 3001;


//conexão com mysql
const con = mysql.createConnection({
host:'localhost',
user:'root',
password: '',
database: 'EncontreJaDatabase'

});

//password 
const getRandomString = function(length){
    return crypto.randomBytes(Math.ceil(length/2))
        .toString('hex') // convert em hexadecimal
        .slice(0,length); 
};

const sha512 = function(password,salt){
      let   hash = crypto.createHmac('sha512',salt);
      hash.update(password);
      let value = hash.digest('hex');
      return {
          salt:salt,
          passwordHash:value
      };
};

function saltHashPassword(userPassword){
    let salt = getRandomString(16); // Gera string aleatoria de 16 caracters para Salt
    let passwordData= sha512(userPassword,salt);
    return passwordData;
}

function checkHashPassword(userPassword,salt)
{
    let passwordData = sha512(userPassword,salt);
    return passwordData;

}

const app = express();
app.use(bodyParser.json()); //Aceitar parametros Json
app.use(bodyParser.urlencoded({extended: true})); //aceitar parametros de URL coidificada

//Start servidor local
app.listen(PORT, () =>{
    console.log(`Servidor Rodando na porta ${PORT}`);
})




// registrando profissional
app.post('/registrarusuario/',(req,res,next)=>{
    let post_data = req.body; //pegando parametros do POST
    let uid = uuid.v4(); // pegando codigo uuid v4
    let plaint_password = post_data.password; // pegando parametros do form post
    let hash_data = saltHashPassword(plaint_password);
    let password = hash_data.passwordHash; // pegando valor hash
    let salt = hash_data.salt; //get salt

    let name = post_data.name;
    let email = post_data.email;
    let email_contato = post_data.email_contato;
    let empresa = post_data.email_contato;
    let data = post_data.data;
    let telefone = post_data.telefone;
    let cep = post_data.cep;
    let sexo = post_data.sexo;

    con.query('SELECT * FROM usuario_profissional where email=?',[email], function(err,result,fields){ //procurando se existe email na tabela profissionais
        con.on('error',function(err){
            console.log('[MySQL ERROR]',err);
        });

        if(result && result.length)
            res.json('Usuario Existente!!!'); //retornando caso tenha
        else        
        { //caso nao tenha busque se tem na tabela empresa
            con.query('SELECT * FROM usuario_empresa where email=?',[email], function(err,result,fields){
                con.on('error',function(err){
                    console.log('[MySQL ERROR]',err);
                });

                if(result && result.length){        //caso tenha retorna resposta            
                    res.json('Usuario existente, cadastre-se com outro email!');
                }    
                else        
                {                       // caso nao tenha em nenhuma das 2 tableas crie um novo usuario profissional       
                    con.query('INSERT INTO `usuario_profissional`(`unique_id`, `name`, `email`, `encrypted_password`, `salt`, `email_contato`, `empresa`, `data`, `telefone`, `cep`, `sexo`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,?,?,?,?,?,?,NOW(),NOW())',[uid,name,email,password,salt,email_contato,empresa,data,telefone,cep,sexo],
                    function(err,result,fields){
                        con.on('error',function(err){
                            console.log('[MySQL ERROR',err);
                            res.json('Erro ao Registrar:',err );
                        });
                        res.json('Registrado com sucesso!');
                    })   
                }
                });
        }
    });
})



// registrando empresa
app.post('/registrarempresa/',(req,res,next)=>{
    let post_data = req.body; //pegando parametros do POST
    let uid = uuid.v4(); // pegando codigo uuid v4
    let plaint_password = post_data.password; // pegando parametros do form post
    let hash_data = saltHashPassword(plaint_password);
    let password = hash_data.passwordHash; // pegando valor hash
    let salt = hash_data.salt; //get salt

    let name = post_data.name;
    let email = post_data.email;
    let empresa = post_data.empresa;
    let responsavel = post_data.responsavel;
    let description = post_data.description;
    let email_contato = post_data.email_contato;   

con.query('SELECT * FROM usuario_empresa where email=?',[email], function(err,result,fields){ //procurando se existe email na tabela empresas
    con.on('error',function(err){
        console.log('[MySQL ERROR]',err);
    });

    if(result && result.length)
        res.json('Usuario existente, cadastre-se com outro email!'); //retornando caso tenha
    else        
    { //caso nao tenha busque se tem na tabela profissional
        con.query('SELECT * FROM usuario_profissional where email=?',[email], function(err,result,fields){
            con.on('error',function(err){
                console.log('[MySQL ERROR]',err);
            });

            if(result && result.length){  //caso tenha retorna resposta            
                res.json('Usuario existente, cadastre-se com outro email!');
            }    
            else        
            {          // caso nao tenha em nenhuma das 2 tableas crie um novo usuario profissional       
                con.query('INSERT INTO `usuario_empresa`(`nique_id`, `name`, `email`, `encrypted_password`, `salt`, `empresa`, `responsavel`, `description`,`email_contato`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,?,?,?,?,NOW(),NOW())',[uid,name,email,password,salt,empresa,responsavel,description,email_contato],
                function(err,result,fields){
                    con.on('error',function(err){
                        console.log('[MySQL ERROR',err);
                        res.json('Erro ao Registrar:',err );
                    });
                    
                    res.json('Registrado com sucesso!');
                })   
            }
            });
    }
});
})



//Login
app.post('/login/',(req,res,next)=>{
    let post_data = req.body;

    //extrai senha e email para o request
    let user_password = post_data.password;
    let email = post_data.email;

    con.query('SELECT * FROM usuario_profissional where email=?',[email], function(err,result,fields){
        con.on('error',function(err){
            console.log('[MySQL ERROR]',err);
        });

        if(result && result.length) //caso encontre email colete a senha e  o email para comparação ao banco na tablea usuario_profissional
        {
                    let salt = result[0].salt;  //pega resultado salt caso seja um conta existente
                    let encrypted_password = result[0].encrypted_password;
                    // hash passaword do login co salt no banco de dados
                    let hashed_password = checkHashPassword(user_password,salt).passwordHash;
                                    
                    if(encrypted_password == hashed_password)
                        res.end(JSON.stringify(result[0]),console.log(`Usuario logou ${email}`)) // se senha for verdadeira , retorna todos informações do usuario
                        
                        
                    else
                        res.end(JSON.stringify('Senha digitada inválida'));        
        }

        else    //caso não encontre email busque na tabela empresa e colete a senha o email para comparação ao banco
       
        {                   con.query('SELECT * FROM usuario_empresa where email=?',[email], function(err,result,fields){
                            con.on('error',function(err){
                                console.log('[MySQL ERROR]',err);
                            });

                            if(result && result.length)
                            {
                        
                                let salt = result[0].salt;  //pega resultado salt caso seja um conta existente
                                let encrypted_password = result[0].encrypted_password;
                                // hash passaword do login co salt no banco de dados
                                let hashed_password = checkHashPassword(user_password,salt).passwordHash;
                                
                                if(encrypted_password == hashed_password)
                                
                                    res.end(JSON.stringify(result[0]),console.log(`Usuario logou ${email}`)) // se senha for verdadeira , retorna todos informações do usuario
                                    
                                else
                                    res.end(JSON.stringify('Senha digitada inválida'))       
                            }
                            else //caso não encontre em nehuma tabela, usuario nao exite
                            {
                                res.json('Usuario Não Existente!!!');
                            }
        })
     }
        
    });

})




// Cadastrar Vagas 
app.post('/cadastrarvagas/',(req,res,next)=>{
    let post_data = req.body; //pegando parametros do POST
  
    let id_empresa = post_data.id;
    let cargo = post_data.cargo;
    let empresa = post_data.empresa;
    let competencia1 = post_data.competencia1;
    let competencia1nivel = post_data.competencia1nivel;
    let competencia2 = post_data.competencia2;
    let competencia2nivel = post_data.competencia2nivel;
    let competencia3 = post_data.competencia3;
    let competencia3nivel = post_data.competencia3nivel;  
    let competencia4 = post_data.competencia4;
    let competencia4nivel = post_data.competencia4nivel;
    let competencia5 = post_data.competencia5;
    let competencia5nivel = post_data.competencia5nivel;
    let vagas = post_data.vagas;
    let contrato = post_data.contrato;
    let description = post_data.description;       
            
                    
                con.query('INSERT INTO `empresa_vagas`(`cargo`, `empresa`, `competencia_1`, `competencia_1_nivel`, `competencia_2`, `competencia_2_nivel`, `competencia_3`, `competencia_3_nivel`, `competencia_4`, `competencia_4_nivel`, `competencia_5`, `competencia_5_nivel`, `vagas`, `description`, `fk_empresa`, `contrato`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)',[cargo,empresa,competencia1,competencia1nivel,competencia2,competencia2nivel,competencia3,competencia3nivel,competencia4,competencia4nivel,competencia5,competencia5nivel,vagas,description,id_empresa,contrato],
                function(err,result,fields){
                    con.on('error',function(err){
                        console.log('[MySQL ERROR',err);
                        res.json('Erro ao Registrar:',err );
                    });
                    
                    res.json('Vaga registrada com sucesso!');
                })   
 
 });
