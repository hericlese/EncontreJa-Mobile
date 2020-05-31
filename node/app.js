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

    con.query('SELECT * FROM usuario_profissional where email=?',[email], function(err,result,fields){
        con.on('error',function(err){
            console.log('[MySQL ERROR]',err);
        });

        if(result && result.length)
            res.json('Usuario Existente!!!');
        else
        {

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

})


app.post('/login/',(req,res,next)=>{
    let post_data = req.body;

    //extrai senha e email para o request
    let user_password = post_data.password;
    let email = post_data.email;

    con.query('SELECT * FROM usuario_profissional where email=?',[email], function(err,result,fields){
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
                res.end(JSON.stringify(result[0])) // se senha for verdadeira , retorna todos informações do usuario
                
            else
                res.end(JSON.stringify('Senha Errada'));        
        }
        else
        {
            res.json('Usuario Não Existente!!!');
        }
    });

})





