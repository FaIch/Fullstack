Cypress.on('uncaught:exception', (err, runnable) => {
    return false;
  });

describe('form', () => {
    beforeEach(()=>{
        cy.visit('/form')
    })


    it('should finds objects', ()=>{
        cy.get('#formBox').should('be.visible')
        cy.get('#nameInput').should('be.of')
        cy.get('#submitButton').should('be.disabled')
    })

    it('should enable button correctly', ()=>{
        cy.get('#submitButton').should('be.disabled')
        cy.get('#nameInput').type("TestName")
        cy.get('#emailInput').type('test@test.com')
        cy.get('#messageInput').type("test message")
        cy.get('#submitButton').should('be.enabled')
        })

    it('should remove message, and keep "name" and "email"', ()=>{
        cy.get('#nameInput').type("TestName")
        cy.get('#emailInput').type('test@test.com')
        cy.get('#messageInput').type("test message")
        cy.get('#submitButton').click()
        cy.get('#nameInput').should("have.value","TestName")
        cy.get('#messageInput').should("be.empty")
    })

    it('should display success upon correct data input', ()=>{
        cy.get('#nameInput').type("TestName")
        cy.get('#emailInput').type('test@test.com')
        cy.get('#messageInput').type("test message")
        cy.get('#submitButton').click()
        cy.get('#resultdiv').should('have.text',"Success!")
    })
})