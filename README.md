# groovy-pluggings
plugins for jenkins

#DOCKER
You need to create a toke on your docker-hub and add it on your jenkins credentials, The ID of the credential is used on the code to help plugin connect and push the builded image to your repositories on Docker hub.
  - next step use k8s to build deployement of the image on gcp instance

#Deployment on Workers
This step help deploy the builded jar on remode machine  it require jdk install on the remote machine
- Genererates id_rsa and id_rsa.pub on jenkins machine
- copy the content on the id_rsa on jenkins credentials
- install jenkins plugin for ssh (agennt ssh)
- copy the content of the id_rsa.pub on contents of the remote machine on authentication_key to allow the two servver to comminicat
- copy the id_rsa fill on jenkins user profile on jenkins machine to allow the unser (jenkins) to connected  to remote server
  *   sudo mkdir -p /var/lib/jenkins/.ssh/
  *   sudo cp /home/vagrant/.ssh/id_rsa.pub /var/lib/jenkins/.ssh/
  *   sudo cp /home/vagrant/.ssh/id_rsa /var/lib/jenkins/.ssh/
  *   sudo chown -R jenkins:jenkins /var/lib/jenkins/.ssh/
  *   sudo chmod 700 /var/lib/jenkins/.ssh/
  *   sudo chmod 600 /var/lib/jenkins/.ssh/id_rsa
  *   sudo chmod 644 /var/lib/jenkins/.ssh/id_rsa.pub




