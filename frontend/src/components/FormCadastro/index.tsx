import React, { ChangeEvent, useState } from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { Announcement } from '../../types/announcement';
import api from '../../services/api';

import './style.css';

const FormCadastro: React.FC = () => {
  const [announcement, setAnnouncement] = useState<Announcement>({
    nomeDoAnuncio: '',
    cliente: { nome: '' },
    dataDeInicio: '',
    dataDeTermino: '',
    investimentoPorDia: 0.0,
  });

  function updateAnnouncement(e: ChangeEvent<HTMLInputElement>) {
    setAnnouncement({
      ...announcement,
      [e.target.name]: e.target.value,
    });
  }

  async function createAds(e: ChangeEvent<HTMLFormElement>) {
    e.preventDefault();

    const response = await api.post('/announcements', announcement);

    console.log(response.data);
  }

  return (
    <Form onSubmit={createAds} id="form-cadastro" className="mt-5">
      <Form.Group as={Col} controlId="formAnuncio">
        <Form.Label>Nome do anúncio</Form.Label>
        <Form.Control
          type="text"
          name="nomeDoAnuncio"
          placeholder="Insira o nome do anúncio"
          onChange={(e: ChangeEvent<HTMLInputElement>) => updateAnnouncement(e)}
        />
      </Form.Group>

      <Form.Group as={Col} controlId="formCliente">
        <Form.Label>Cliente</Form.Label>
        <Form.Control
          type="text"
          name="cliente"
          placeholder="Insira o nome do cliente"
          onChange={(e: ChangeEvent<HTMLInputElement>) => updateAnnouncement(e)}
        />
      </Form.Group>

      <Row>
        <Form.Group as={Col}>
          <Form.Label>Data de início</Form.Label>
          <Form.Control
            type="date"
            name="dataDeInicio"
            onChange={(e: ChangeEvent<HTMLInputElement>) =>
              updateAnnouncement(e)
            }
          />
        </Form.Group>
        <Form.Group as={Col}>
          <Form.Label>Data de término</Form.Label>
          <Form.Control
            type="date"
            name="dataDeTermino"
            onChange={(e: ChangeEvent<HTMLInputElement>) =>
              updateAnnouncement(e)
            }
          />
        </Form.Group>

        <Form.Group as={Col}>
          <Form.Label>Valor de investimento</Form.Label>
          <Form.Control
            type="number"
            name="investimentoPorDia"
            placeholder="R$"
            onChange={(e: ChangeEvent<HTMLInputElement>) =>
              updateAnnouncement(e)
            }
          />
        </Form.Group>
      </Row>
      <Form.Group as={Col} id="div-btn-cadastro">
        <Button variant="success mt-5" size="lg" type="submit">
          Cadastrar anúncio
        </Button>
      </Form.Group>
    </Form>
  );
};

export default FormCadastro;
