import "./Sidebar2.css";
import logo from "../../assets/logoCih.png";
import authService from "../../../services/auth.service";

const Sidebar = ({ sidebarOpen, closeSidebar }) => {  
  return (
    <div className={sidebarOpen ? "sidebar_responsive" : ""} id="sidebar">
      <div className="sidebar__title">
        <div className="sidebar__img">
          <img src={logo} alt="logo" />
          <h1>CareInHome</h1>
        </div>
        <i
          onClick={() => closeSidebar()}
          className="fa fa-times"
          id="sidebarIcon"
          aria-hidden="true"
        ></i>
      </div>

      <div className="sidebar__menu">
        <div className="sidebar__link active_menu_link">
          <i className="fa fa-home"></i>
          <a href="#">Dashboard</a>
        </div>
        
        <h2>Traitement</h2>
        <div className="sidebar__link">
          <i className="fa fa-medkit" aria-hidden="true"></i>
          <a href="/médicament">Informations</a>
        </div>

        <div className="sidebar__link">
          <i className="fa fa-handshake-o"></i>
          <a href="/messagerieP">Messagerie</a>        </div>
        
        <div className="sidebar__logout">
          <i className="fa fa-power-off"></i>
          <a href="/login" onClick={authService.logout}>Log out</a>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;