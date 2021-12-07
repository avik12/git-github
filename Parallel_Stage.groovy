pipeline{
    agent any 
    stages{
        stage ('Compile'){
            steps {
                echo 'First stage'
            }
        }
        stage ('Test'){
            parallel{
                stage ('Junit'){
                    steps {
                        echo 'Junit testing is happening'
                    }
                }
                stage ('Selenium'){
                    steps {
                        echo 'Selenium testing'
                    }
                }

            }
         }
    }      
}