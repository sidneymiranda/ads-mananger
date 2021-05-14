import FormConsulta from 'components/FormConsulta';
import React, { useEffect } from 'react';

const Cadastro: React.FC = () => {
  useEffect(() => {
    document.title = 'Consulta de relatórios';
  }, []);

  return (
    <div className="container">
      <h1 className="mt-3 text-center">Consulta de anúncios</h1>
      <FormConsulta />
    </div>
  );
};

export default Cadastro;
