import "./Navbar.css";
import avatar from "../../assets/avatar.png";
import { Link } from "react-router-dom";

const Navbar = ({ sidebarOpen, openSidebar }) => {
  
  return (
    
    <nav className="navbar">
      <div className="nav_icon" onClick={() => openSidebar()}>
        <i className="fa fa-bars" aria-hidden="true"></i>
      </div>
      <div className="navbar__left">
        <a className="active_link" href="#">
          Médecin
        </a>
      </div>
      <div className="navbar__right">
        <Link to={"/profilAgent"}>
        <a href="#!">
          <img width="40" src={avatar} alt="avatar" />
        </a>
        </Link>
      </div>
    </nav>
  );
};

export default Navbar;
