import FormConsulta from 'components/FormConsulta';
import React, { useEffect } from 'react';

const Cadastro: React.FC = () => {
  useEffect(() => {
    document.title = 'Consulta de relatórios';
  }, []);

  return (
    <>
      <h1 className="mt-3 text-center">Relatório de projeções</h1>
      <FormConsulta />
    </>
  );
};

export default Cadastro;
