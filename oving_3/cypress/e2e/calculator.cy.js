Cypress.on('uncaught:exception', (err, runnable) => {
  return false;
});

describe('calculator', () => {
  beforeEach(()=>{
    cy.visit('/')
  })

  it('Finds the component', () => {
    cy.get('section').should('have.class', 'screen')
    cy.get('#5').should('have.text', '5')
  })

  it('adds two numbers',() =>{
    cy.get('#2').should('have.text','2').click();
    cy.get('button:contains("+")').click();
    cy.get('#2').click();
    cy.get('button:contains("=")').click();
    cy.get('.screen').should('have.text', '4')
  })

  
  it('subtracts two numbers',() =>{
    cy.get('#5').click();
    cy.get('button:contains("-")').click();
    cy.get('#3').click();
    cy.get('button:contains("=")').click();
    cy.get('.screen').should('have.text', '2');
  })
  
  it('should not get wrong output',() =>{
    cy.get('#8').click();
    cy.get('#x').click();
    cy.get('#7').click();
    cy.get('button:contains("=")').click();
    cy.get('.screen').should('not.have.text', '60');
  })

})