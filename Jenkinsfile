pipeline {
    agent any
    stages {
   
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
                 sh 'cp /var/lib/jenkins/workspace/NUST_Paynow_Integration/target/*.war /var/lib/jenkins/workspace/NUST_Paynow_Integration/target/paynow.war'
                 sh 'cp /var/lib/jenkins/workspace/NUST_Paynow_Integration/target/paynow.war /var/lib/tomcat9/webapps'
             }
         }  
          stage ('Reload Tomcat Server') {

             steps {
                sh 'sudo systemctl restart tomcat9'
             }
         }  
    }
}
