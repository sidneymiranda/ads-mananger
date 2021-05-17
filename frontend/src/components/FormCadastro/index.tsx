import React, { ChangeEvent, useState } from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { Announcement } from '../../types/announcement';
import api from '../../services/api';
import { useHistory } from 'react-router-dom';

import './style.css';

const FormCadastro: React.FC = () => {
  const [validated, setValidated] = useState(false);

  const history = useHistory();

  const [announcement, setAnnouncement] = useState<Announcement>({
    adName: '',
    client: { name: '' },
    startDate: '',
    endDate: '',
    investedTotal: 0.0,
  });

  function updateAnnouncement(e: ChangeEvent<HTMLInputElement>) {
    setAnnouncement({
      ...announcement,
      [e.target.name]: e.target.value,
    });
  }

  async function handleSubmit(e: ChangeEvent<HTMLFormElement>) {
    const form = e.currentTarget;
    if (!form.checkValidity()) {
      e.preventDefault();
      e.stopPropagation();
    }

    setValidated(true);

    try {
      const response = await api
        .post('', announcement)
        .then(() => alert('Anúncio cadastrado com sucesso!'));
      console.log(response);
      history.push('/');
    } catch (err) {
      alert('Falha no cadastro, verifique os campos!');
    }
  }

  return (
    <>
      <Form
        noValidate
        validated={validated}
        onSubmit={handleSubmit}
        id="form-cadastro"
        className="mt-5"
      >
        <Form.Group as={Col} controlId="formAnuncio">
          <Form.Label>Nome do anúncio</Form.Label>
          <Form.Control
            required
            type="text"
            name="adName"
            placeholder="Insira o nome do anúncio"
            onChange={(e: ChangeEvent<HTMLInputElement>) =>
              updateAnnouncement(e)
            }
          />
        </Form.Group>

        <Form.Group as={Col} controlId="formCliente">
          <Form.Label>Cliente</Form.Label>
          <Form.Control
            required
            type="text"
            name="client"
            placeholder="Insira o nome do cliente"
            onChange={(e: ChangeEvent<HTMLInputElement>) =>
              updateAnnouncement(e)
            }
          />
        </Form.Group>

        <Row>
          <Form.Group as={Col}>
            <Form.Label>Data de início</Form.Label>
            <Form.Control
              required
              type="date"
              name="startDate"
              onChange={(e: ChangeEvent<HTMLInputElement>) =>
                updateAnnouncement(e)
              }
            />
          </Form.Group>
          <Form.Group as={Col}>
            <Form.Label>Data de término</Form.Label>
            <Form.Control
              required
              type="date"
              name="endDate"
              onChange={(e: ChangeEvent<HTMLInputElement>) =>
                updateAnnouncement(e)
              }
            />
          </Form.Group>

          <Form.Group as={Col}>
            <Form.Label>Valor de investimento</Form.Label>
            <Form.Control
              required
              type="number"
              name="investedTotal"
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
    </>
  );
};

export default FormCadastro;
