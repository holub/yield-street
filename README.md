1. Given a long list of names, find the first name which is unique

2. Given the following data packet

|-----+-----+-----+------|
| Seq | Chk | Len | Data |
|-----+-----+-----+------|

| Name | Description            | Length in bytes |
|------+------------------------+-----------------|
| Seq  | Packet sequence number |               1 |
| Chk  | Checksum               |               4 |
| Len  | Data length            |               4 |
| Data | Raw data               |               n |

Cheksum algorithm - XOR the packet sequence number with the first data byte, keep xoring the result with all data bytes sequentially. if data length doesn’t divide by 4, pad it with 0xAB (Big Endian)
Assuming an array of 500 of the above data packets filter the valid ones.

3. Use your favorite Java MVC framework
* Define a JSON model that represents an investor’s performance over time for a given year (% ROI)
* Create an HTML page and use your favorite front-end framework
* Display a select box with 2 options, by month and by quarter
* When a selection is made, retrieve the result from the server via a REST call and display it in a div
* The above grouping should be done on the client side. hint, angular filters/group by,  backbone _.groupBy

Please share the results with us via GitHub
The 3rd task SHOULDN'T be deployed on a remote server. a localhost solution is perfectly fine.
