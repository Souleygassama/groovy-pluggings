def call() {
    echo "Copying jar to workers"
/*sshagent(['vargrant-public-key']) {
    sh """
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "mkdir -p /home/vagrant/deploy/sama-gp"
        scp -o StrictHostKeyChecking=no target/samagp-api-ms-0.0.1-SNAPSHOT.jar vagrant@192.168.56.11:/home/vagrant/deploy/sama-gp/sama-gp-annonce.jar 
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "sudo pkill -f sama-gp-annonce"
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "nohup java -jar /home/vagrant/deploy/sama-gp/sama-gp-annonce.jar > /home/vagrant/deploy/sama-gp/app.log 2>&1 &"
    """
}*/    
    sshagent(['vagrant-public-key']) {  
        sh """
            ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "mkdir -p /home/vagrant/deploy/sama-gp"
            scp -o StrictHostKeyChecking=no -i ~/.ssh/id_rsa target/samagp-api-ms-0.0.1-SNAPSHOT.jar vagrant@192.168.56.11:/home/vagrant/deploy/sama-gp/sama-gp-annonce.jar 
            ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "nohup java -jar /home/vagrant/deploy/sama-gp/sama-gp-annonce.jar > /home/vagrant/deploy/sama-gp/app.log 2>&1 &"
        """
    }
       
}
