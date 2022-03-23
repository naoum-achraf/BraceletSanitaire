import "./Main.css";
import hello from "../../assets/hello.ico";
import Navbar from "../navbar/Navbar";
import Sidebar from "../sidebar/Sidebar"
import AuthService from "../../../services/auth.service";
import axios from 'axios';
import {Button, ButtonGroup, Card, Table} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faAd, faClipboardList, faEdit, faList, faTrash, faTruckLoading} from '@fortawesome/free-solid-svg-icons';
import UserService from "../../../services/user.service"; 
import React from "react";
import { Link } from "react-router-dom";
import {faPlusSquare, faSave, faUndo} from '@fortawesome/free-solid-svg-icons';



class Main extends React.Component{
  constructor(props){
    super(props);
    this.state = {
        Infos : []
    };
}
  
componentDidMount(){
  axios.get("http://localhost:8080/api/test/Myinfos/"+AuthService.getCurrentUser().id)
  .then(Response => Response.data)
  .then((data) => {
      this.setState({Infos: data});
      console.log(data)
  })
}    

  render(){ 
  return (
     
    <div className="container2">
    <Navbar/>
    <main>
      <div className="main__container ">
        {/* <!-- MAIN TITLE STARTS HERE --> */}

        <div className="main__title">
          <img src={hello} alt="hello" />
          <div className="main__greeting">
            <h1>Bonjour {AuthService.getCurrentUser().username}</h1>
            <p>Mes Infos </p>
          </div>
        </div>
    <div className="container">
    {
                 this.state.Infos.map((infos) =>
(   
    <Table striped bordered hover variant="withe">
        
             
        <tbody className="ligne">
        
          
          <tr>
            <th width="15%">Type de douleur à la poitrine</th>
            {infos.chestPainType ===null ? (<td colSpan="2">No défini</td>) :(<td colSpan="2">{infos.chestPainType}</td>)}
          </tr>   
      <tr>
      <th>Cholesterol (mm/dl)</th>
      {infos.cholesterol ===null ? (<td colSpan="2">No défini</td>) :(<td colSpan="2">{infos.cholesterol}</td>)}
      </tr>
          <tr>
            <th>Angine causée par l'exercice</th>
            {infos.exerciseAngina ===null ? (<td colSpan="2">No défini</td>) :(<td colSpan="2">{infos.exerciseAngina}</td>)}
      
          </tr>
      
          <tr>
            <th>Glycémie à jeun du patient</th>
            {infos.fastingBS ===null ? (<td colSpan="2">No défini</td>) :(<td colSpan="2">{infos.fastingBS}</td>)}
          </tr>
      
          <tr>
            <th>Pression artérielle au repos</th>
            {infos.restingECG ===null ? (<td colSpan="2">No défini</td>) :(<td colSpan="2">{infos.restingECG}</td>)}
          </tr>
      
          <tr>
            <th width="15%">la pente de l'exercice de pointe</th>
            {infos.st_Slope ===null ? (<td colSpan="2">No défini</td>) :(<td colSpan="2">{infos.st_Slope}</td>)}
          </tr>
      
          <tr>
            <th>Oldpeak</th>
            {infos.oldpeak ===null ? (<td colSpan="2">No défini</td>) :(<td colSpan="2">{infos.oldpeak}</td>)}
          </tr>
      
                                                                      
      
        </tbody>  
      </Table>
      )  
   
                    )
                    
                    }
      </div>
      </div>
    </main>
    <Sidebar />
   </div>
    
    
  );
                      }
};

export default Main;
