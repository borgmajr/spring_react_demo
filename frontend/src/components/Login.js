//import 'bootstrap/dist/css/bootstrap.min.css';
import React, { Component } from 'react';
import HomePage from "./HomePage";
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = { username: '', password: '', isAuthenticated: false, open: false, errorMsg: '' };
    }

    login = () => {
        const user = { userName: this.state.username, password: this.state.password };
        fetch('/login', {
            method: 'POST',
            body: JSON.stringify(user)
        })
            .then(res => {
                const jwtToken = res.headers.get('Authorization');
                if (jwtToken !== null) {
                    sessionStorage.setItem("jwt", jwtToken);
                    this.setState({ isAuthenticated: true });
                }
                else {
                    this.setState({ open: true, errorMsg: 'Invalid Login' });
                }
            })
            .catch(err =>
                console.error(err)
            )
    };

    handleChange = (event) => {
        this.setState({ [event.target.name]: event.target.value });
    };

    render() {
        if (this.state.isAuthenticated === true) {
            return (<HomePage />)
        }
        else {
            return (
                <div id="login">
                    <div className="container">

                        <Grid
                            container
                            spacing={0}
                            direction="column"
                            alignItems="center"
                            justify="center"
                            style={{ minHeight: '100vh' }}
                        >

                            <Grid item xs={3}>
                                <div id="login-row" className="row justify-content-center align-items-center">
                                    <div id="login-column" className="col-md-6">
                                        <div id="login-box" className="col-md-12">
                                            <div>
                                                {/* <input type="text" name="username" onChange={this.handleChange} className="form-control" placeholder="username" /> */}
                                                <TextField name="username" onChange={this.handleChange} id="standard-basic" label="Username" />
                                            </div>
                                            <div>
                                                {/* <input type="password" name="password" onChange={this.handleChange} className="form-control" placeholder="password" /> */}
                                                <TextField name="password" type="password" onChange={this.handleChange} id="standard-basic" label="Password" />
                                            </div>
                                            {/* <input type="submit" name="submit" onClick={this.login} className="btn btn-info btn-md" value="Login" /> */}
                                            <Button type="submit" name="submit" onClick={this.login} variant="contained" color="primary">
                                                Login
                                            </Button>
                                        </div>
                                    </div>
                                </div>
                                <div style={{ color: "red" }}>{this.state.errorMsg}</div>
                            </Grid>

                        </Grid>

                    </div>
                </div>

            );
        }
    }
}

export default Login;