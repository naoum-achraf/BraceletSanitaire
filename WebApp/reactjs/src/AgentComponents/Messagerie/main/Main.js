import "./Main.css";
import hello from "../../assets/hello.svg";
import Navbar from "../navbar/Navbar";
import Sidebar from "../sidebar/Sidebar"
import AuthService from "../../../services/auth.service";
import axios from 'axios';
import {Card, Form, Button,Col} from 'react-bootstrap'; 
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faAd, faBell, faEdit, faInfo, faList, faTrash} from '@fortawesome/free-solid-svg-icons';
import React from "react";
import { Link } from "react-router-dom";
import {faPlusSquare, faSave, faUndo} from '@fortawesome/free-solid-svg-icons';
import {CircleProgress} from 'react-gradient-progress'
import {ButtonGroup, Table} from 'react-bootstrap';
import Modal from 'react-bootstrap/Modal'

class Main extends React.Component{

  constructor(props){
    super(props);
    this.state = {
        Messages : [],
    };
}



componentDidMount(){
  axios.get("http://localhost:8080/api/test/AllmessagesM/"+AuthService.getCurrentUser().id)
  .then(Response => Response.data)
  .then((data) => {
      this.setState({Messages: data});
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
            <p>Boite Messagerie avec Les patients</p>
          </div>
        </div>

        <Table striped bordered hover variant="white" >
        <tbody>
        <tr>
          <th>Name</th>
          <th>Message</th>
        </tr>
        {
                        
                        this.state.Messages.length ===0 ?
                            <tr align="center">
                                <td colSpan="6"> Messages indisponibles</td>
                            </tr> :
                            this.state.Messages.map((agent) => (
                              
                                <tr key={agent.id}>
                                    <td>{agent.nameSender}</td>
                                    <td>{agent.message}</td>
                                    
                                </tr>


                            ))

                            
                            
                        }
                                          
        </tbody>
      </Table>



        </div>

      
      
    </main>

                 <Sidebar />

    
   </div>
    
    
  );
                      }
};

export default Main;
