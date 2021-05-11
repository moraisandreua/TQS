import React from 'react';
import { Link } from 'react-router-dom';
import Chart from 'react-google-charts';
import './App.css';

export default class Logs extends React.Component {
    constructor() {
        super();
        this.state = {
            requests: [],
            errors: [],
            elapsed_time: []
        }
    }

    componentDidMount() {
        fetch("http://localhost:8080/api/v1/logs").then(data => data.json()).then(data => this.setState({ requests: data.requests, errors: data.errors, elapsed_time: data.elapsed_time }));
    }

    render() {
        return (
            <div className="App">
                <div className="NavBar">
                    <div className="NavBarTitle"><Link to="/">AirQuality</Link></div>
                    <div className="NavBarWrapper"></div>
                </div>
                <div className="Cards">
                    <div className="Card">
                        {(this.state.errors.length > 0) ?
                            <Chart
                                width={'500px'}
                                height={'300px'}
                                chartType="PieChart"
                                loader={<div>Loading Chart</div>}
                                data={this.state.requests}
                                options={{
                                    title: 'All requests',
                                }}
                                rootProps={{ 'data-testid': '1' }}
                            /> : <div></div>
                        }
                    </div>
                    <div className="Card">
                        {(this.state.errors.length > 0) ?

                            <Chart
                                width={'500px'}
                                height={'300px'}
                                chartType="PieChart"
                                loader={<div>Loading Chart</div>}
                                data={this.state.errors}
                                options={{
                                    title: 'Request errors',
                                }}
                                rootProps={{ 'data-testid': '1' }}
                            /> :

                            <div></div>
                        }
                    </div>
                </div>
                <div className="Cards">
                    <div className="Card">
                        <Chart
                            width={'600px'}
                            height={'400px'}
                            chartType="LineChart"
                            loader={<div>Loading Chart</div>}
                            data={this.state.elapsed_time}
                            options={{
                                hAxis: {
                                    title: 'Time',
                                },
                                vAxis: {
                                    title: 'Popularity',
                                },
                            }}
                            rootProps={{ 'data-testid': '1' }}
                        />
                    </div>
                    <div className="Card">

                    </div>
                </div>
            </div>
        )
    }
}