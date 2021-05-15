import React from 'react';
import { Nav, Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom';

import './style.css';

const Header: React.FC = () => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg" id="nav">
      <Navbar.Brand href="">ADS Mananger</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <Nav.Item as={Link} to="/" className="nav-link">
            Cadastro
          </Nav.Item>
          <Nav.Item as={Link} to="/consulta" className="nav-link">
            Consulta
          </Nav.Item>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
};

export default Header;
