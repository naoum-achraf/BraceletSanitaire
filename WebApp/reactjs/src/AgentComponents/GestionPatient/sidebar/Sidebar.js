import "./Sidebar1.css";
import logo from "../../assets/logoCih.png";
import authService from "../../../services/auth.service";

const Sidebar = ({ sidebarOpen, closeSidebar }) => {  
  return (
    <div className={sidebarOpen ? "sidebar_responsive" : ""} id="sidebar">
      <div className="sidebar__title">
        <div className="sidebar__img">
          <img src={logo} alt="logo" />
          <h1>SAFE HEART</h1>
        </div>
        <i
          onClick={() => closeSidebar()}
          className="fa fa-times"
          id="sidebarIcon"
          aria-hidden="true"
        ></i>
      </div>

      <div className="sidebar__menu">
        <div className="sidebar__link ">
          <i className="fa fa-home"></i>
          <a href="/agent">Accueil</a>
        </div>
        
        <h2>Gestion</h2>
        <div className="sidebar__link active_menu_link">
          <i className="fa fa-users" aria-hidden="true"></i>
          <a href="/crudPatient">Patients</a>
        </div>
        <div className="sidebar__link">
          <i className="fa fa-heart-o"></i>
          <a href="/suivre">Etats des Patients</a>
        </div>
        <div className="sidebar__link">
          <i className="fa fa-envelope"></i>
          <a href="#">Messagerie</a>
        </div>
        
        <div className="sidebar__logout">
          <i className="fa fa-power-off"></i>
          <a href="/login" onClick={authService.logout}>Log out</a>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;