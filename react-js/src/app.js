import React from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import NavigationBar from './navigation-bar'
import Home from './home/home';
import Patient from './person-data/person/patient'
import Care from './care-data/care/care'
import Caregiver from './caregiver-data/caregiver/caregiver'


import styles from './commons/styles/project-style.css';

let enums = require('./commons/constants/enums');

class App extends React.Component {


    render() {

        return (
            <div className={styles.back}>
            <Router>
                <div>
                    <NavigationBar />
                    <Switch>

                        <Route
                            exact
                            path='/'
                            render={() => <Home/>}
                        />

                        <Route
                        exact
                        path='/patient'
                        render={() => <Patient/>}
                        />


                        <Route
                            exact
                            path='/caregiver'
                            render={() => <Caregiver/>}
                            />

                        <Route
                            exact
                            path='/patient'
                            render={() => <Care/>}
                        />

                        />
                    </Switch>
                </div>
            </Router>
            </div>
        )
    };
}

export default App
