import { Link, useLocation } from "react-router-dom";
import Button from "../Button/Button";
import { IoMdArrowDropdown } from "react-icons/io";
import { FaUserEdit } from "react-icons/fa";
import { IoExitOutline } from "react-icons/io5";
import { FaChartBar } from "react-icons/fa";
import { useState } from "react";
export default function Nav() {
  const { state } = useLocation();
  const [visible, setVisible] = useState(false);

  const onClick = () => {
    setVisible(!visible);
  };

  return (
    <header className="header">
      <div className="div_header">
        <Link to="/">
          <img src="/src/assets/logo/logo.png" alt="" className="img" />
        </Link>
      </div>

      {state?.logged ? (
        <div className="paste_button">
          <Button classNameButon="button_profile" onClick={onClick}>
            <IoMdArrowDropdown
              style={{
                color: "#FFFFFF",
                fontSize: "30px",
              }}
            />
            <div className="button_username">{state?.username}</div>
            <img
              src="https://avatars.githubusercontent.com/u/95192731?v=4&s=48"
              alt="img_profile"
              className="img_profile"
            />
          </Button>

          {visible && (
            <ul className="dropdown">
              <li className="dropdown_profile dropdown_link">
                <FaUserEdit
                  style={{
                    color: "#5d5c5c",
                    fontSize: "20px",
                  }}
                />
                <Link to=" ">Your Profile</Link>
              </li>
              <li className="dropdown_statistics dropdown_link">
                <FaChartBar
                  style={{
                    color: "#5d5c5c",
                    fontSize: "20px",
                  }}
                />
                <Link to="/ranking">statistics</Link>
              </li>
              <li className="dropdown_LogOut dropdown_link">
                <IoExitOutline
                  style={{
                    color: "#5d5c5c",
                    fontSize: "20px",
                  }}
                />
                <Link to="/instructions">Log out</Link>
              </li>
            </ul>
          )}
        </div>
      ) : (
        <nav className="navbar">
          <ul className="links">
            <li className="link">
              <Link to="/">Home</Link>
            </li>
            <li className="link">
              <Link to="/instructions">Instructions</Link>
            </li>
            <li className="link">
              <Link to="/ranking">Ranking</Link>
            </li>
          </ul>
        </nav>
      )}
    </header>
  );
}
