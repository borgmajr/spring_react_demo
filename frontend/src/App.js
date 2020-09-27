import React, {Component} from 'react';
import './App.css';
import Login from './components/Login'

class App extends Component {
    render() {
        return (
            <div className="App">
                <header className="Header">
                    <h1 className="App-title">Starter App</h1>
                </header>
                <Login />

            </div>
        )
    }
}

export default App;