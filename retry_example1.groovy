pipeline {
   agent any
   stages {
       stage('Build') {
           options {
               retry(2)
           }
           steps {
               catchError{
                    retry(3) {
                        echo "Error 1"
                        error("error1")
                    }
               }
               echo "Error 2"
               error("error2")
           }
       }
   }
}