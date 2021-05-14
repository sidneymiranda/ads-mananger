import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Cadastro from './pages/Cadastro';
import Consulta from './pages/Consulta';

const Routes: React.FC = () => {
  return (
    <Switch>
      <Route exact path="/" component={Cadastro} />
      <Route path="/consulta" component={Consulta} />
    </Switch>
  );
};

export default Routes;
