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

const app = express();
app.use(bodyParser.json()); //Aceitar parametros Json
app.use(bodyParser.urlencoded({extended: true})); //aceitar parametros de URL coidificada

//Start servidor local
app.listen(PORT, () =>{
    console.log(`Servidor Rodando na porta ${PORT}`);
})

app.post('/registrar/',(req,res,next)=>{
    let post_data = req.body; //pegando parametros do POST
    let uid = uuid.v4(); // pegando codigo uuid v4
    let plaint_password = post_data.password; // pegando parametros do form post
    let hash_data = saltHashPassword(plaint_password);
    let password = hash_data.passwordHash; // pegando valor hash
    let salt = hash_data.salt; //get salt

    let name = post_data.name;
    let email = post_data.email;

    con.query('SELECT * FROM usuario_profissional where email=?',[email], function(err,result,fields){
        con.on('error',function(err){
            console.log('[MySQL ERROR]',err);
        });

        if(result && result.length)
            res.json('Usuario Existente!!!');
        else
        {
            con.query('INSERT INTO `usuario_profissional`(`unique_id`, `name`, `email`, `encrypted_password`, `salt`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,NOW(),NOW())',[uid,name,email,password,salt], 
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


/*
app.get("/",(req,res,next)=>{
    console.log('Password: 123456');
    let encrypt = saltHashPassword("123456");
    console.log('Encrypt:'+encrypt.passwordHash);
    console.log('Salt:'+encrypt.salt);

})*/


