import React, { Component } from 'react';
import axios from 'axios';


class HomePage extends Component {
    constructor(props) {
        super(props);
    }

    state = {};

    componentDidMount() {
        setInterval(this.fetchtime, 250);
        //this.fetchtime();
    }

    // fetchtime = () => {
    //     fetch('/api/system/time')
    //         .then(response => response.text())
    //         .then(message => {
    //             this.setState({ message: message });
    //         });
    // };

    fetchtime = () => {

        const jwtToken = sessionStorage.getItem("jwt");
        axios.get('/api/system/time', {
                headers: {
                    "Authorization": jwtToken,
                    "Content-Type": "application/json"
                }
            })
            .then(res => {
                this.setState({ message: res.data });
            })
            .catch(function (error) {
                // handle error
                console.log(error);
            })

        // const jwtToken = sessionStorage.getItem("jwt");
        // fetch('http://localhost:3000/api/system/time', {
        //     headers: new Headers({
        //         "Authorization": jwtToken,
        //         "Content-Type": "application/json"
        //     })
        // }) 
        // .then((responseData) => {    
        //    this.setState({ message: responseData.message })  
        // }) 
        // // .then(message => {
        // //     this.setState({ message: message });
        // // })
        // .catch(err =>
        //     this.setState({ message: err })
        // );

    };

    render() {
        return (
            <div className="App">

        <h1 className="App-title">{this.state.message}</h1>

            </div>
        );
    }
}

export default HomePage;    