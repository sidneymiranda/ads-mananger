import FormCadastro from 'components/FormCadastro';
import React, { useEffect } from 'react';

const Cadastro: React.FC = () => {
  useEffect(() => {
    document.title = 'Cadastro de anúncio';
  }, []);

  return (
    <div className="container">
      <h1 className="text-center mt-3">Formulário de cadastro</h1>
      <FormCadastro />
    </div>
  );
};

export default Cadastro;
