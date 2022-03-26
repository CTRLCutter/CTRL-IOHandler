# CTRL-IOHandler
A project which contains file IO-Handling helpers for the CTRLCutter project.

## Usage

When using the file writing capabilities you have to use the following arguments in that order.

- <code>a</code> - Should the file content be appended to the file or should a fresh file be created. True => Append, False => New File.
- <code>p</code> - The complete absolute file path of the referenced file.
- <code>c</code> - The file content which should be used for file writing.