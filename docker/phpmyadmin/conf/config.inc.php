<?php
$cfg['blowfish_secret']='multiServerExample70518';
//any string of your choice
$i = 0;

$i++; // server 1 :
$cfg['Servers'][$i]['auth_type'] = 'cookie';
$cfg['Servers'][$i]['verbose']   = 'data1.huntor.cn';
$cfg['Servers'][$i]['port']   = '3306';
$cfg['Servers'][$i]['host']      = 'data1.huntor.cn';
$cfg['Servers'][$i]['extension'] = 'mysqli';
// more options for #1 ...

$i++; // server 2 :
$cfg['Servers'][$i]['auth_type'] = 'cookie';
$cfg['Servers'][$i]['verbose']   = 'server5';
$cfg['Servers'][$i]['port']   = '3306';
$cfg['Servers'][$i]['host']      = '192.168.1.5';
$cfg['Servers'][$i]['extension'] = 'mysqli';
// more options for #2 ...

// end of server sections
$cfg['ServerDefault'] = 0; // to choose the server on startup

// further general options ...
?>
