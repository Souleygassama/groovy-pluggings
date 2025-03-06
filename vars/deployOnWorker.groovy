def call() {
    echo "Copying jar to workers"
 sshagent(['vargrant-public-key']) {
    sh """
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "mkdir -p /home/vagrant/deploy/sama-gp"
        scp -o StrictHostKeyChecking=no target/*.jar vagrant@192.168.56.11:/home/vagrant/deploy/sama-gp/sama-gp-annonce.jar

        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 << 'EOF'
            # Stop any running instance of the application
            pkill -f 'sama-gp-annonce.jar' || true
            
            # Start the application in the background
            nohup java -jar /home/vagrant/deploy/sama-gp/sama-gp-annonce.jar > /home/vagrant/deploy/sama-gp/app.log 2>&1 &
        EOF
    """
}
       
}
