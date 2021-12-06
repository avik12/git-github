pipeline{
    agent any
            stages {
                    stage ('One'){
                        steps {
                            echo 'Hi This is first stage'

                        }

                    }
                    stage ('Two'){
                        steps {
                              input ('Do you want to continue')    
                        }

                    }
                    stage ('Three'){
                                when {
                                    not {
                                            branch "master"
                                    }    
                                }
                                steps {
                                    echo 'hello'
                                }

                    }


    }
}