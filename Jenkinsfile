pipeline {
    agent any
    stages {
        stage ('Compile Stage') {

            steps {
                sh 'mvn clean verify'
                }
            }
    stage ('Version'){
            steps {
                sh 'mvn --version'
            }
        }
        
            stage ('Check User'){
            steps {
                sh 'whoami'
            }
            
        }
        
         stage ('Deploy') {

             steps {
                 sh 'cp /var/lib/jenkins/workspace/NUST_Online_Application_WebApp/target/*.war /var/lib/jenkins/workspace/NUST_Online_Application_WebApp/target/paynow.war'
                 sh 'cp /var/lib/jenkins/workspace/NUST_Online_Application_WebApp/target/paynow.war /var/lib/tomcat9/webapps'
             }
         }  
          stage ('Reload Tomcat Server') {

             steps {
                sh 'sudo systemctl restart tomcat9'
             }
         }  
    }
}
