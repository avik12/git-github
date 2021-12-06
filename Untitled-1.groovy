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
                    stage ('Four'){
                                parallel {
                                    stage ('Unit Test') {
                                        agent {
                                            docker {
                                                reuseNode false
                                                image 'ubuntu'
                                            }
                                        }
                                       steps{ echo 'Unit Test'
                                       }
                                    }
                                    stage ('Integration Test'){
                                        steps{echo 'Integration Test'    
                                        }
                                    }
                                }



                    }


    }
}