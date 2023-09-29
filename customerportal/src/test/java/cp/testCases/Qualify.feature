Feature: Qualify Request

Background:
*	def new_email = "brinder" +Math.floor(Math.random() * 10000)+"@gmail.com"
*	print new_email

Scenario: DTC Partner API flow
* def req_headers = {Content-Type:'application/json', Accept:'application/json', Exchange-Format:'Core'}
*	def query = {key : 'xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF'}
Given headers req_headers
And url 'https://testapi.lendingpoint.com/api/lead/qualify?key=xHvLmlZ3wPt2oBOPMV7g7U65ZvG8P%2F4V22l1aASRAuWrSxr0x9Oqm4Nb6DCJCAKF'
*	def req = read("Requestdata.json").Qualify_request
* req.email = new_email
*	print req
And request req
When method POST
Then status 200
* print response
*	def expectedResult = read("Sampleresult.json").QualifySampleResponse
And match $.offerStatus == expectedResult.offerStatus
And match response.offers[0] == expectedResult.offers[0]
And match response.offers[1] == expectedResult.offers[1]
And match response.lead == expectedResult.lead
##*	def qualifyResponse = response
##*	def varLeadSubSource = qualifyResponse.lead.leadSubSource
##*	def varLeadProvider = qualifyResponse.lead.leadProvider
##*	def varOfferId = qualifyResponse.offers[0].id
##*	def oppID = qualifyResponse.lead.applicationId
##*	def varEmail = response.lead.email
##*	print varLeadSubSource
##*	print varLeadProvider
##*	print varOfferId
##*	print oppID