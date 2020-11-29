<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <style>
        div#interface2 {
        background-color: white;
        width: 500px;
        height: 300px;
        margin-top: 100px;
        margin-left: 350px;
        padding: 10px 10px 10px 10px;
        box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.295);
        text-align: center;
        }
        p {
            color: black;
            text-decoration: none;
        }
        h2 {
            margin-top: 80px;
        }
    </style>
    <title>Document</title>
</head>
<body>
    <div id="interface2">
    <?php
        $nome = isset($_POST['nome'])?$_POST['nome']:0;
        $ano = isset($_POST['ano'])?$_POST['ano']:0;
        $email = isset($_POST['email'])?$_POST['email']:0;
        $tel = isset($_POST['tel'])?$_POST['tel']:0;
        

        // coloco tudo na mesma mensagem 

        $mensagem = "$nome $ano $email $tel";
        $to = "pmachado.new@gmail.com";
        $ass = "Contatos";
       

        if(mail ($to,$ass,$mensagem) != 0){
            echo "<h2>Informações Enviadas com Sucesso!</h2>";
            
            //envio para o meu e-mail
        }else{
            echo "<h2>As Informações Não foram enviadas por favor repita o processo</h2>";
            
            
        }  
    ?>
    <br>
    </div>
    <footer>
        <a href="javascript:history.go(-1)">Voltar</a>
    </footer>
    
</body>
</html>