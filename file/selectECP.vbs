Set WshShell = WScript.CreateObject("WScript.Shell")

DIM i, ecpNumber
ecpNumber = 2
i = 0

WScript.Sleep(2000)

DO

i = i + 1

WshShell.SendKeys("{DOWN}")
WScript.Sleep(500)

LOOP WHILE i < ecpNumber

WshShell.SendKeys("{ENTER}")
WScript.Sleep(100)