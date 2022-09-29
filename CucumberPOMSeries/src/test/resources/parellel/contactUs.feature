Feature: Contact Us Feature

Scenario Outline: Contact Us scenario with different set of data
Given user navigates to contact us page
When user fills the form from given sheet name "<SheetName>" and rownumber <RowNumber>
And user clicks on Send button
Then it shows successfull message "Your message has been successfully sent to our team."

Examples:
|SheetName|RowNumber|
|contactus|0|
|contactus|1|
|contactus|2|
|contactus|3|
|contactus|4|
|contactus|5|