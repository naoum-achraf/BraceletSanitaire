import "./Main.css";
import hello from "../../assets/hello.svg";
import Navbar from "../navbar/Navbar";
import Sidebar from "../sidebar/Sidebar"
import AuthService from "../../../services/auth.service";
import axios from 'axios';
import {Card, Form, Button,Col} from 'react-bootstrap'; 
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faAd, faEdit, faList, faTrash} from '@fortawesome/free-solid-svg-icons';
import UserService from "../../../services/user.service"; 
import React from "react";
import { Link } from "react-router-dom";
import {faPlusSquare, faSave, faUndo} from '@fortawesome/free-solid-svg-icons';
import { useHistory } from "react-router-dom";



class Main extends React.Component{

  constructor(props){
    super(props);
    this.state=this.initialState;
    this.voitureChange = this.voitureChange.bind(this);
    this.submitAgent = this.submitAgent.bind(this);
    this.state = {
      Age:'',
      Sex:'',
      ChestPainType:'',
      Cholesterol:'',
      FastingBS:'',
      RestingECG:'',
      ExerciseAngina:'',
      oldpeak:'',
      ST_Slope:'',
      Danger:'',
    };
}

initialState = {
  Age:'',
  Sex:'',
      ChestPainType:'',
      Cholesterol:'',
      FastingBS:'',
      RestingECG:'',
      ExerciseAngina:'',
      oldpeak:'',
      ST_Slope:'',
      Danger:''
}   

resetVoiture = () => {
  this.setState(() => this.state
  );
}
  
submitAgent = event => {
  event.preventDefault();
  const agent={
      age:this.state.Age,
      sex:this.state.Sex,
      chestPainType:this.state.ChestPainType,
      cholesterol:this.state.Cholesterol,
      fastingBS:this.state.FastingBS,
      restingECG:this.state.RestingECG,
      exerciseAngina:this.state.ExerciseAngina,
      oldpeak:this.state.oldpeak,
      st_Slope:this.state.ST_Slope,
      danger:this.state.Danger
  };      
  const windowUrl = window.location.search;
  const params = new URLSearchParams(windowUrl);
  const CarId = params.get("id");


axios.put("http://localhost:8080/api/test/Infos/"+CarId,agent)
      .then(response => {
      if (response.data != null) {
        this.setState(this.initialState);
        window.location.replace("/suivre")

      }else{
        alert("wrong")
      }
});
}



componentDidMount() {
  
  const windowUrl = window.location.search;
  const params = new URLSearchParams(windowUrl);
  const CarId = params.get("id");
  if (CarId) {
          axios.get("http://localhost:8080/api/test/infosUp/"+CarId)
          .then(Response => Response.data)
          .then((data) => {
            let infos =data;

            this.setState({Age:infos.age,Sex:infos.sex,ChestPainType:infos.chestPainType, Cholesterol:infos.cholesterol,FastingBS:infos.fastingBS,RestingECG:infos.restingECG,ExerciseAngina:infos.exerciseAngina,oldpeak:infos.oldpeak,ST_Slope:infos.st_Slope,Danger:infos.danger});            
          })
      }
}

voitureChange =event => { 
  this.setState ( { 
          [event.target.name]:event.target.value } ); 

}   


  render(){ 
  return (
    <div className="container2">
    <Navbar/>
    <main>
      <div className="main__container ">
       {}


        <div className="main__title">
          <img src={hello} alt="hello" />
          <div className="main__greeting">
            <h1>Hello {AuthService.getCurrentUser().username}</h1>
            <p>Welcome to Update des agents</p>
          </div>
        </div>

        <div className="Form">

        
            <Form onReset={this.resetVoiture} onSubmit={this.submitAgent} id="VoitureFormId"> 
           
         <Form.Row> 
         <Form.Group as={Col} controlId="formGridAge"> 
               <Form.Label> Age </Form.Label> 
               <Form.Control required name="Age" type="text" autoComplete="off" value={this.state.Age} onChange={this.voitureChange}  placeholder= "Entrez Age"/> 
            </Form.Group> 
            <Form.Group as={Col} controlId="formGridSex"> 
               <Form.Label> Sex </Form.Label> 
               <Form.Control required name="Sex" type="text" autoComplete="off" value={this.state.Sex} onChange={this.voitureChange}  placeholder= "Entrez Sex"/> 
            </Form.Group> 
            <Form.Group as={Col} controlId="formGridChestPainType"> 
               <Form.Label> ChestPainType </Form.Label> 
               <Form.Control required name="ChestPainType" type="text" autoComplete="off" value={this.state.ChestPainType} onChange={this.voitureChange}  placeholder= "Entrez ChestPainType"/> 
            </Form.Group> 

            <Form.Group as={Col} controlId="formGridCholesterol"> 
                    <Form.Label> Cholesterol </Form.Label> 
                    <Form.Control required  name="Cholesterol" type="text" value={this.state.Cholesterol} autoComplete="off" onChange={this.voitureChange} placeholder= "Entrez Cholesterol"/>
            </Form.Group>

            <Form.Group as={Col} controlId="formGridFastingBS"> 
                    <Form.Label> FastingBS </Form.Label> 
                    <Form.Control required value={this.state.FastingBS} name="FastingBS" type="text"  autoComplete="off" onChange={this.voitureChange}  placeholder= "Entrez FastingBS"/>
            </Form.Group>

            <Form.Group as={Col} controlId="formGridImmatricule"> 
               <Form.Label> RestingECG </Form.Label> 
               <Form.Control required value={this.state.RestingECG} name="RestingECG"  type="text"  autoComplete="off" onChange={this.voitureChange} placeholder= "Entrez RestingECG"/> 
            </Form.Group> 
            <Form.Group as={Col} controlId="formGridRestingECG"> 
               <Form.Label> ExerciseAngina </Form.Label> 
               <Form.Control required name="ExerciseAngina" type="text" autoComplete="off" value={this.state.ExerciseAngina} onChange={this.voitureChange}  placeholder= "Entrez ExerciseAngina"/> 
            </Form.Group> 

            <Form.Group as={Col} controlId="formGridoldpeak"> 
                    <Form.Label> oldpeak </Form.Label> 
                    <Form.Control required  name="oldpeak" type="text" value={this.state.oldpeak} autoComplete="off" onChange={this.voitureChange} placeholder= "Entrez oldpeak"/>
            </Form.Group>

            <Form.Group as={Col} controlId="formGridST_Slope"> 
                    <Form.Label> ST_Slope </Form.Label> 
                    <Form.Control required value={this.state.ST_Slope} name="ST_Slope" type="text"  autoComplete="off" onChange={this.voitureChange}  placeholder= "Entrez ST_Slope"/>
            </Form.Group>

            <Form.Group as={Col} controlId="formGridDanger"> 
                    <Form.Label> Danger </Form.Label> 
                    <Form.Control required value={this.state.Danger} name="Danger" type="text"  autoComplete="off" onChange={this.voitureChange}  placeholder= "Entrez Danger"/>
            </Form.Group>
            
            </Form.Row> 

                 <div style={{"textAlign":"right"}}>
                      <Button size="sm" variant="success" type="submit"><FontAwesomeIcon icon={faSave} /> Update </Button> <i>&nbsp;</i>
                      <Button size="sm" variant="info" type="reset"><FontAwesomeIcon icon={faUndo} /> Reset </Button>
                      </div>
            </Form>
        </div>
      </div>
    </main>
    <Sidebar />
   </div>
    
    
  );
                      }
};

export default Main;
