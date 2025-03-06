def call() {
    echo "Copying jar to workers"
  /*  sh '''#!/bin/bash
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "sudo mkdir -p /home/vagrant/deploy/samagp"
        
        scp -o StrictHostKeyChecking=no target/samagp-api-ms-0.0.1-SNAPSHOT.jar vagrant@192.168.56.11:/home/vagrant/deploy/samagp/
    '''*/
    /*
    sh """
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "sudo mkdir -p /home/vagrant/deployment/sama-gp"
        scp -o StrictHostKeyChecking=no target/*.jar vagrant@192.168.56.11:/home/vagrant/deployment/sama-gp/sama-gp-annonce.jar
        ssh vagrant@192.168.56.11 << 'EOF'
            pkill -f 'sama-gp-annonce.jar' || true  # Stop existing process if running
            nohup java -jar /opt/deployment/sama-gp/sama-gp-annonce.jar > /opt/deployment/app.log 2>&1 &
        EOF
    """
    */
    /*
    sshagent(['vargrant-public-key']) {
    sh '''#!/bin/bash
    ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "sudo mkdir -p /home/vagrant/deploy/samagp3"
    '''
}*/
     
    /*sh """
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "sudo mkdir -p /home/vagrant/deploy/samagp"
        scp -o StrictHostKeyChecking=no target/*.jar vagrant@192.168.56.11:/home/vagrant/deploy/samagp/sama-gp-annonce.jar
        ssh vagrant@192.168.56.11 << 'EOF'
            pkill -f 'sama-gp-annonce.jar' || true  # Stop existing process if running
            nohup java -jar /home/vagrant/deploy/samagp/sama-gp-annonce.jar > /opt/deployment/app.log 2>&1 &
        EOF
    """*/
     def jarPath = "target/samagp-api-ms-0.0.1-SNAPSHOT.jar"
    def remoteUser = "vagrant"
    def remoteHost = "192.168.56.11"
    def remotePath = "/opt/deployment/sama-gp/sama-gp-annonce.jar"
    def privateKeyPath = "~/.ssh/id_rsa"
    
   def command = "scp -i ${privateKeyPath} -o StrictHostKeyChecking=no ${jarPath} ${remoteUser}@${remoteHost}:${remotePath}"
    
    println "Executing: ${command}"
    
    def process = command.execute()
    process.waitFor()

    if (process.exitValue() == 0) {
        println "JAR copied successfully to ${remoteHost}:${remotePath}"
    } else {
        println "Failed to copy JAR. Error: ${process.err.text}"
    }    
}
