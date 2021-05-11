import React from 'react';

export default class Main extends React.Component {
    constructor(){
        super();
        this.state={
            alreadySearched:[],
            search:"",
            o3:[{"day":"10-05-2021", "avg":"33", "min":"28", "max":"38"}],
            pm10:[{"day":"10-05-2021", "avg":"33", "min":"28", "max":"38"}],
            pm25:[{"day":"10-05-2021", "avg":"33", "min":"28", "max":"38"}],
            uvi:[{"day":"10-05-2021", "avg":"33", "min":"28", "max":"38"}]
        }
    }

    search = (e) => {
        if(e.which === 13) {
            fetch("http://localhost:8080/api/v1/city/"+this.state.search).then(data => data.json()).then(data => this.setState({o3:data.data.forecast.daily.o3, pm10:data.data.forecast.daily.pm10, pm25:data.data.forecast.daily.pm25, uvi:data.data.forecast.daily.uvi}));
        }
    }

    componentDidMount(){
        console.log(this.state.o3);
        fetch("http://localhost:8080/api/v1/cities").then(data => data.json()).then(data => this.setState({alreadySearched:data}));
    }

    render () {
        return (
            <div className="App">
                <div className="NavBar">
                    <div className="NavBarTitle">AirQuality</div>
                    <div className="NavBarWrapper"></div>
                    <div className="NavBarSearch">
                        {
                            (this.state.search.length > 3) ? 
                                <div className="suggestions">
                                    {
                                        
                                        this.state.alreadySearched.filter(word => word.toLowerCase().includes(this.state.search.toLowerCase())).map(r => 
                                        <div key={r}>
                                            <div onClick={() => this.setState({search:r})}>{r}</div>
                                        </div>)
                                    }
                                </div>
                            : <span></span>
                        }
                        <input type="text" placeholder="City or country..." value={this.state.search} onChange={(evt) => this.setState({search:evt.target.value})} onKeyDown={this.search}/>
                    </div>
                </div>
                <div className="Cards">
                    <div className="Card">
                        <div className="Box">
                            <div className="BoxTitle">o3</div>
                            <div className="BoxBody">
                            {
                                this.state.o3.map(element => 
                                <div key={"o3_"+element.day}>
                                    <div className="BoxBodyDay">{element.day}</div>
                                    <div className="BoxBodyItem">Media: {element.avg}</div>
                                    <div className="BoxBodyItem">Min: {element.min}</div>
                                    <div className="BoxBodyItem">Max: {element.max}</div>
                                </div>
                                )
                            }
                            </div>
                        </div>
                    </div>
                    <div className="Card">
                        <div className="Box">
                            <div className="BoxTitle">pm10</div>
                            <div className="BoxBody">
                            {
                                this.state.pm10.map(element => 
                                <div key={"pm10_"+element.day}>
                                    <div className="BoxBodyDay">{element.day}</div>
                                    <div className="BoxBodyItem">Media: {element.avg}</div>
                                    <div className="BoxBodyItem">Min: {element.min}</div>
                                    <div className="BoxBodyItem">Max: {element.max}</div>
                                </div>
                                )
                            }
                            </div>
                        </div>
                    </div>
                    <div className="Card">
                        <div className="Box">
                            <div className="BoxTitle">pm25</div>
                            <div className="BoxBody">
                            {
                                this.state.pm25.map(element => 
                                <div key={"pm25_"+element.day}>
                                    <div className="BoxBodyDay">{element.day}</div>
                                    <div className="BoxBodyItem">Media: {element.avg}</div>
                                    <div className="BoxBodyItem">Min: {element.min}</div>
                                    <div className="BoxBodyItem">Max: {element.max}</div>
                                </div>
                                )
                            }
                            </div>
                        </div>
                    </div>
                    <div className="Card">
                        <div className="Box">
                            <div className="BoxTitle">uvi</div>
                            <div className="BoxBody">
                            {
                                this.state.uvi.map(element => 
                                <div key={"uvi_"+element.day}>
                                    <div className="BoxBodyDay">{element.day}</div>
                                    <div className="BoxBodyItem">Media: {element.avg}</div>
                                    <div className="BoxBodyItem">Min: {element.min}</div>
                                    <div className="BoxBodyItem">Max: {element.max}</div>
                                </div>
                                )
                            }
                            </div>
                        </div>
                    </div>
                    <div className="Card">
                        <div className="Box">
                            <div className="BoxTitle">IAQI</div>
                            <div className="BoxBody">
                            {
                                this.state.o3.map(element => 
                                <div key={"iaqi_"+element.day}>
                                    <div className="BoxBodyDay">{element.day}</div>
                                    <div className="BoxBodyItem">Media: {element.avg}</div>
                                    <div className="BoxBodyItem">Min: {element.min}</div>
                                    <div className="BoxBodyItem">Max: {element.max}</div>
                                </div>
                                )
                            }
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}