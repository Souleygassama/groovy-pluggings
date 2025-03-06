def call() {
    echo "Copying jar to workers"
sshagent(['vargrant-public-key']) {
    sh """
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "mkdir -p /home/vagrant/deploy/sama-gp1"
        scp -o StrictHostKeyChecking=no target/samagp-api-ms-0.0.1-SNAPSHOT.jar vagrant@192.168.56.11:/home/vagrant/deploy/sama-gp1/sama-gp-annonce.jar
        
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "nohup java -jar /home/vagrant/deploy/sama-gp1/sama-gp-annonce.jar > /home/vagrant/deploy/sama-gp1/app.log 2>&1 &"
    """
}
       
}
