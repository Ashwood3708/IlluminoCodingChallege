Your  job  is  to  implement  a  Firewall  class,  whose  interface  contains  two  items:    

•   A  constructor,  taking  a  single  string  argument,  which  is  a  file  path  to  a  CSV  file  whose   contents  are  as  described  above,  e.g,  in  Ruby,  this  would  be   Firewall.new(“/path/to/fw.csv”).    
o Note  that  you  do  not  need  to  define  a  static  ‘new’  method  –  simply  use  the   constructor  syntax  in  the  language that  you  chose.   
o Remember  that  you  may  assume  that  all  content  in  the  input  file  is  valid.     

•   A  function,  accept_packet,  that  takes  exactly  four  arguments  and  returns  a  boolean:   true,  if  there  exists  a  rule  in  the  file  that  this  object  was  initialized  with  that  allows  traffic   with  these  particular  properties,  and  false  otherwise.  
	o   direction  (string):  “inbound”  or  “outbound”  
	o   protocol  (string):  exactly  one  of  “tcp”  or  “udp”,  all  lowercase   
	o   port  (integer)  –  an  integer  in  the  range  [1,  65535]   
	o   ip_address  (string):  a  single  well‐formed  IPv4  address.     

You  may  assume  that  all  arguments  passed  into  the  accept_packet  function  will  be  well-formed  according  to  the  spec  above.     Feel  free  to  define  any  additional  functions  or  classes  you  might  want;  the  only  thing  we  ask  is   that  you  don’t  change  the  interface  described  above.     In  your  implementation,  you  should  consider  efficiency  and  tradeoffs  in  both  space  and  time   complexity.  There  may  be  a  massive  number  of  rules  (use  500K  entries  as  a  baseline),  and  real-­‐ world  firewalls  must  be  able  to  store  this  in  a  reasonably  compact  form  while  introducing  only   negligible  latency  to  incoming  and  outgoing  network  traffic.  Keep  in  mind  that  IP  address  and   port  ranges  may  be  very  wide  –  your  code  should  be  able  to  handle  the  cases  of  “all  IPs”   (0.0.0.0-­‐255.255.255.255)  and  “all  ports”  (1-­‐65535)  specified  via  ranges.  

Introduction------

So I approached this problem as a verify the data problem
where I came up with many ideas on how to store the information using maps and trees, but I settled for a List structure.
I decided that the best way to store the information and to later compare was to use a List<List<String[]>> 
and seperate each input by the direction and protocol since each had only 2 possible outcomes.
This created 4 arraylist of String arrays that would divide the inputs by 4 and decrease the runtime as well since you are only 
looking at input values that share the same direction and protocol.

For the function accept_packet() I created hepler methods that would return boolean values if port and ip address matched.
For the ip address I shifted the bits and them compared them.

Testing and future Enhancement-------

Although creating 4 List of ArrayList would use more space than makeing a node or hash, It will save time on 
the verification step due to divideing the original list into 4.
I ran simple examples using the test.txt above, but ran out of time to find all the edge cases.
If I were given more time I would do more extensive testing and compare to see if other structures would better benefit 
the outcome.


Area of Interest----------
I am most interseted in the Platform team becease I am looking to dive deeper into API's, Infrustructure and server support.
For a close second, the Data team interest me for dealing with a lot of metadata, interfaces, and queries.


	
