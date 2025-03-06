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
     
    sh """
        ssh -o StrictHostKeyChecking=no vagrant@192.168.56.11 "sudo mkdir -p /home/vagrant/deploy/samagp"
        scp -o StrictHostKeyChecking=no target/*.jar vagrant@192.168.56.11:/home/vagrant/deploy/samagp/sama-gp-annonce.jar
        ssh vagrant@192.168.56.11 << 'EOF'
            pkill -f 'sama-gp-annonce.jar' || true  # Stop existing process if running
            nohup java -jar /home/vagrant/deploy/samagp/sama-gp-annonce.jar > /opt/deployment/app.log 2>&1 &
        EOF
    """
    
}
