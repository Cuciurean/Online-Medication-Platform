import React from 'react';

import BackgroundImg from '../commons/images/future-medicine.jpg';

import {Button, Container, Jumbotron} from 'reactstrap';

const backgroundStyle = {
    backgroundPosition: 'center',
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
    width: "100%",
    height: "1920px",
    backgroundImage: `url(${BackgroundImg})`
};
const textStyle = {color: 'white', };

class Home extends React.Component {
    render() {

        return (

            <div>
                <Jumbotron fluid style={backgroundStyle}>
                    <Container fluid>
                        <h1 className="display-3" style={{color: 'blue'}}>            Integrated Medical Monitoring Platform for Home-care assistance</h1>
                        <p className="lead" style={{color: 'blue'}}> <b>Enabling real time monitoring of patients, remote-assisted care services and
                            smart intake mechanism for prescribed medication.</b> </p>
                        <hr className="my-2"/>
                    </Container>
                </Jumbotron>

            </div>
        )
    };
}
export default Home
