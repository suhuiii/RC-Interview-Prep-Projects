#!/usr/bin/python3

import locale
import csv
import re
from os.path import isfile

class tsv_reader:

	def __init__(self):
		self.__num_w_commas_pattern = re.compile('^[0-9]{1,3}(,[0-9]{3})*(\.[0-9]+)?$')
		self.data = []
		self.min_values = {}
		self.max_values = {}
		
	def process_file(self, file = None):
		if file is None:
			file = 'demo.tsv'

		try:
			with open(file, newline='', encoding='utf-8') as f:
				reader = csv.reader(f, delimiter='\t', skipinitialspace = True)

				# save first line as header
				self.headers = tuple(reader.__next__())

				# rest of lines are data
				[self.process_line(line) for line in reader]

				return '%s processed...' % file

		except IOError as e:
			raise

	def process_line(self, line):
		values = tuple([self.convert_numeric_strings(value) for value in line])

		for i in range(len(self.headers)):
			corr_header = self.headers[i]

			# keep track of lowest value
			if corr_header not in self.min_values or values[i] < self.min_values[corr_header]:
				self.min_values[corr_header] = values[i]

			# keep track of highest value
			if corr_header not in self.max_values or values[i] > self.max_values[corr_header]:
				self.max_values[corr_header] = values[i]

		# add to data
		self.data += line

		return 

	def convert_numeric_strings(self, value):
		if self.__num_w_commas_pattern.match(value):
			value = value.replace(',', '')

		# try casting to integer
		try:
			return int(value)
		except ValueError:
			pass
		# then try casting to float
		try:
			return float(value)
		# otherwise return original string
		except ValueError:
			return value

	def is_a_valid_header(self, header):
		return header in self.headers

	def get_max_for_header(self, header):
		if self.is_a_valid_header(header):
			return self.max_values[header]
		return None

	def get_min_for_header(self, header):
		if self.is_a_valid_header(header):
			return self.min_values[header]

		return None

def main():
	reader = tsv_reader()
	
	while(True):
		file = input('Enter file name of tsv data (press enter to read default file in data\demo.py): \r\n')

		if not file:
			reader.process_file()
			break
		else: 
			try:
				reader.process_file(file)
				break
			except FileNotFoundError:
				print("Error opening file: %s" % file)

	print_help()
	
	while True:
		command, column = get_user_input()

		if command == 'help':
			print_help(True)
		elif command =='quit':
			break
		else:
			if command =='min':
				result = reader.get_min_for_header(column)
			elif command =='max':
				result = reader.get_max_for_header(column)
			
			if result is None:
				print('Column does not exist!')
			else:
				print('The {0} value for column \'{1}\' is {2}'.format(command, column, result))

			
def get_user_input():
	new_input = input("\r\nWhat would you like to do?\r\n")

	if new_input:
		user_input = new_input.split()
		
		if user_input[0] == 'help' or user_input[0] == 'quit':
			return (user_input[0],(),)

		elif user_input[0] == 'min' or user_input[0] == 'max':
			
			if len(user_input) is 1:
				user_input.append(input("Enter column name: "))
				print(user_input)
			elif len(user_input) > 2:
				print("number of arguments exceeds 1. Only the first argument will be used")

			return (user_input[0], user_input[1],)

		else:
			print("Not a valid command. Type help for a list of available commands and example usage.")

	get_user_input()



def print_help(addn_help = False):
	print("--- TSV PARSER ---")
	print("Usage:")
	print("\t command [argument]")
	print("Available commands:")
	print("\t max")
	print("\t min")
	print("\t help")
	print("\t quit")
	if(addn_help):
		print("Example usage: To find the maximum value in the column named example_col, type")
		print("max example_col")


if __name__ == '__main__':
	main()