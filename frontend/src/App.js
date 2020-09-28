import React, { Component } from 'react';
import './App.css';
import Login from './components/Login'

class App extends Component {
    render() {
        return (
            <div>
                <div style={{ color: "white", backgroundColor: "red", height: "20px", position: "absolute", top: "0px", width: "100%" }}>
                    Header
                </div>

                <div className="App">

                    <Login />

                </div>

                <div style={{ color: "white", backgroundColor: "red", height: "20px", position: "absolute", bottom: "0px", width: "100%" }}>
                    Footer
                </div>
            </div>
        )
    }
}

export default App;