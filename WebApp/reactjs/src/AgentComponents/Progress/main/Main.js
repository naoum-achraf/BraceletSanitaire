import "./Main1.css";
import hello from "../../assets/hello.svg";
import Navbar from "../navbar/Navbar";
import Sidebar from "../sidebar/Sidebar"
import AuthService from "../../../services/auth.service";
import axios from 'axios';
import {Card, Form, Button,Col} from 'react-bootstrap'; 
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faAd, faBell, faEdit, faInfo, faList, faSms, faTrash, faDigitalTachograph} from '@fortawesome/free-solid-svg-icons';
import React from "react";
import { Link } from "react-router-dom";
import {faPlusSquare, faSave, faUndo} from '@fortawesome/free-solid-svg-icons';
import {CircleProgress} from 'react-gradient-progress'
import {ButtonGroup, Table} from 'react-bootstrap';
import CanvasJSReact from './canvasjs.react';

import Modal from 'react-bootstrap/Modal'

var CanvasJSChart = CanvasJSReact.CanvasJSChart;

class Main extends React.Component{




  constructor(props){
    super(props);
    this.addAlert = this.addAlert.bind(this);
    this.deleteVoiture = this.deleteVoiture.bind(this);
    this.voitureChange = this.voitureChange.bind(this);
    this.submitMessage = this.submitMessage.bind(this);
    this.state = {
        Patients : [],
        show1 : false,
        show2 : false,
        progress1:'',
        progress2:'',
        resultat : '',
        négatives: [],
        Messages : [],
        id:'',
        Infos : [],
        Graph : [1,2],
        Temp : [],
        Tens : []
    };

    //this one
    this.generateDataPoints = this.generateDataPoints.bind(this);

}



//this one


/*
generateDataPoints(noOfDps) {
  var xVal = 1, yVal = 80;
  var dps = [];
  for(var i = 0; i < noOfDps; i++) {
    yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
    dps.push({x: xVal,y: yVal});	
    xVal++;
  }
  return dps;
}
*/


generateDataPoints(noOfDps) {
  var xVal = 1;
  var yVal = 110;
  var dps = [];
  for(var i = 0; i < noOfDps; i++) {
    yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
    dps.push({x: xVal,y: yVal});	
    xVal++;
  }
  return dps;
}



resetVoiture = () => {
  this.setState({Messsage : ''}
 );
}

initialState = {
  message:''
} 


submitMessage = event => { 
  event.preventDefault();
  const message={
          message:this.state.message
  };      

  const config = { headers: {'Content-Type': 'application/json'} };
axios.put("http://localhost:8080/api/test/message/"+8, this.state.message,config)
      .then(response => {
      if (response.data != null) {
              this.setState({ show2: false});
              this.setState(this.initialState);
              alert("Send avec succes")
              
      }else{
        alert("wrong ")
      }
});
}



deleteVoiture = (agentId) => {
  axios.delete("http://localhost:8080/api/test/Agents/"+agentId)
    .then(response => {
      if(response.data != null){
          this.setState({
              Agents: this.state.négatives.filter(agent => agent.id !== agentId)
            })

            window.location.reload(false);
      }
    })
};



handleModal(patientId){
  this.setState({show1: !this.state.show1})


  axios.get("http://localhost:8080/api/test/Allinfos/"+patientId)
  .then(Response => Response.data)
  .then((data) => {
      this.setState({Infos: data});
  })       





  axios.get("http://localhost:8080/api/test/Allgraph/"+patientId)
  .then(Response => Response.data)
  .then((data) => {
      this.setState({Graph: data});
  })  

  axios.get("http://localhost:8080/api/test/Alltemperature/"+patientId)
  .then(Response => Response.data)
  .then((data) => {
      this.setState({Temp: data});
  })  



  axios.get("http://localhost:8080/api/test/Alltension/"+patientId)
  .then(Response => Response.data)
  .then((data) => {
      this.setState({Tens: data});
  })  

  
  axios.get("http://localhost:8080/api/test/résultat/"+patientId)
          .then(Response => Response.data)
          .then((data) => {
            let agent =data;
            if(agent[0].resultat == true){
              this.setState({resultat:'Positive'});
            }else{
              this.setState({resultat:'Négative'});  
            }
                      
          })  


}

handleModal2(){
  this.setState({show2: !this.state.show2})
}


addAlert = (PatientId) =>{
  axios.put("http://localhost:8080/api/test/alert/"+PatientId)
  .then(response => {
  if (response.data != null) {
          alert("Update avec succes")
          window.location.reload(false);

  }else{
    alert("wrong ")
  }
});
}

componentDidMount(){
  axios.get("http://localhost:8080/api/test/allPatients/"+AuthService.getCurrentUser().id)
  .then(Response => Response.data)
  .then((data) => {
      this.setState({Patients: data});
  })

  axios.get("http://localhost:8080/api/test/négatives/"+AuthService.getCurrentUser().id)
  .then(Response => Response.data)
  .then((data) => {
      this.setState({négatives: data});
  })

}  

voitureChange =event => { 
  this.setState ( { 
          [event.target.name]:event.target.value } ); 

}   

  render(){ 
    const { message } = this.state;


    
    //from here
    const options = {
			theme: "light2", // "light1", "dark1", "dark2"
			animationEnabled: true,
			zoomEnabled: true,
			title: {
				text: "Rythme Cardiaque"
			},
			data: [{
				type: "area",
				dataPoints: this.generateDataPoints(15)
			}]
		}



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
            <p>Suivi les etats des patient
            </p>
          </div>
        </div>

        <Table className="one" striped bordered  variant="white" >
        <tbody>
        <tr>
          <th>Username</th>
          <th>Age</th>
        </tr>
        {
                        
                        this.state.Patients.length ===0 ?
                            <tr align="center">
                                <td colSpan="6"> Patients indisponibles</td>
                            </tr> :
                            this.state.Patients.map((agent) => (
                              
                                <tr key={agent.id}>
                                    <td>{agent.username}</td>
                                    <td>{agent.age}</td>
                                    <td>
                                        <ButtonGroup>
                                        <Button variant="info" className="infos" onClick={()=>{this.handleModal(agent.id)}}>  <FontAwesomeIcon icon={faInfo} /> Infos</Button>
                                        {
                 this.state.Infos.map((infos) =>
(        
                                            <Modal size="lg"
                                                  aria-labelledby="contained-modal-title-vcenter"
                                                  centered
                                                  show = {this.state.show1}>
                                                  
      
                                                            <Modal.Header>
                                                                  Patient details
                                                            </Modal.Header>
                                                            <Modal.Body>
                                                            
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

                    </Modal.Body>
                      <Modal.Footer>
                        <ButtonGroup>
                        <Link to={"FormInfos?id="+infos.id} className="btn btn-m btn-warning"> Modifier</Link>
                        </ButtonGroup> 
                          <Button onClick={() =>{this.handleModal()}}>
                            Close
                          </Button>
                      </Modal.Footer>
                      
                    </Modal>
                    )  
   
                    )
                    
                    }


                                                      
                                        <Button variant="danger"  className="infos" onClick={()=>{this.handleModal2()}}> <FontAwesomeIcon icon={faSms} /> Alert </Button> 


                                        <Modal size="lg"
                                                  aria-labelledby="contained-modal-title-vcenter"
                                                  centered
                                                  show = {this.state.show2}>
                                                            <Modal.Header>
                                                                  Message
                                                            </Modal.Header>
                                                            <Modal.Body>
                                                            <Form onReset={this.resetVoiture} onSubmit={this.submitMessage} id="VoitureFormId"> 
           
           <Form.Row> 
              <Form.Group as={Col} controlId="formGridMarque"> 
                 <Form.Control required name="message" as="textarea" type="text" autoComplete="off" value={message} onChange={this.voitureChange}  placeholder= "Saisie votre message ..."/> 
              </Form.Group>
              </Form.Row> 
  
                   <div style={{"textAlign":"right"}}>
                        <Button size="sm" variant="success" type="submit"><FontAwesomeIcon icon={faSave} /> Send </Button> <i>&nbsp;</i>
                        <Button size="sm" variant="info" type="reset"><FontAwesomeIcon icon={faUndo} /> Reset </Button>
                        </div>
              </Form>
                                                            </Modal.Body>
                                                              <Modal.Footer>
                                                                  <Button onClick={() =>{this.handleModal2()}}>
                                                                    Close
                                                                  </Button>
                                                              </Modal.Footer>
                                                      </Modal>                                   
                                        </ButtonGroup>
                                    </td>
                                    
                                </tr>


                            ))

                            
                            
                        }
                                          
        </tbody>
      </Table>

      <h3><br/><FontAwesomeIcon icon={faList}/> Liste des Cas en danger</h3>

      <Table className="one" striped bordered  variant="white" >
        <tbody>
        <tr>
          <th>Username</th>
          <th>Age</th>
        </tr>
        {
                        this.state.négatives.length ===0 ?
                            <tr align="center">
                                <td colSpan="6"> Liste vide</td>
                            </tr> :
                            this.state.négatives.map((agent) => (
                              
                                <tr key={agent.id}>
                                    <td>{agent.username}</td>
                                    <td>{agent.age}</td>
                                    <td>
                                        <ButtonGroup>
     

                                      <Button variant="info" className="infos" onClick={()=>{this.handleModal(agent.id)}}>  <FontAwesomeIcon icon={faDigitalTachograph} /> </Button>
                                        {

                 this.state.Graph.map((infos) =>
(        
  
                                            <Modal size="lg"
                                                  aria-labelledby="contained-modal-title-vcenter"
                                                  centered
                                                  show = {this.state.show1}>
                                                  
                                                            <Modal.Header>
                                                                  Patient details
                                                            </Modal.Header>
                                                            <Modal.Body>
                                                            
                                                            <Table striped bordered hover variant="withe">
                                                            
                                                                      
  <tbody className="ligne">
  <tr>
   
   <div className="chat_area">
                     <div className="row">
                     
                        



                     <CanvasJSChart options = {options} 
				 onRef={ref => this.chart = ref} 
			/>

      </div>
      </div>
      </tr>
      <tr>

      <div className="row dat">
      {
                 this.state.Temp.map((infos) =>
(        
                    <div className="col-md-6">
                      <h2 className="header">Température</h2>
                      <h5 className="head_val">  {infos.a10 ===null ? (<td colSpan="2">No défini</td>) :(<td colSpan="2">{infos.a10}</td>)}</h5>



        



                    </div>
)
                 )
  }
                  </div>

                  </tr>       





                      <tr>

      <div className="row dat">
      {
                 this.state.Tens.map((infos) =>
(        
                    <div className="col-md-6">
                      <h2 className="header">Tension</h2>
                      <h5 className="head_val">  {infos.a9 ===null ? (<td colSpan="2">No défini</td>) :(<td colSpan="2">{infos.a9}</td>)}</h5>

                    </div>
)
                 )
  }
                  </div>

                  </tr>       
                                         

  </tbody>  
</Table>

                    </Modal.Body>
                      <Modal.Footer>
                       
                          <Button onClick={() =>{this.handleModal()}}>
                            Close
                          </Button>
                      </Modal.Footer>
                      
                    </Modal>
                    )  
   
                    )
                    
                    }
















                                        </ButtonGroup>
                                    </td>
                                    
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
