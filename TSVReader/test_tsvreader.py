import pytest
from tsvreader import tsv_reader

@pytest.fixture()
def reader():
	reader = tsv_reader()
	reader.process_file()
	return reader

def test_demo_file_opens_as_default():
	reader = tsv_reader()
	assert reader.process_file() == "demo.tsv processed..."

def test_user_defined_file_error_raises_exception():
	with pytest.raises(IOError) as excinfo:
		reader = tsv_reader()
		reader.process_file("file_that_does_not_exist")
		assert 'IO' in str(excinfo.value)

def test_first_line_processed_as_headers(reader):
	headers = reader.headers 
	assert headers == tuple(['Rank','Country','Population'])

def test_process_line_saves_values():
	reader = tsv_reader()
	reader.headers = tuple(['col1', 'col2'])
	reader.process_line(('123','abc',))
	assert reader.min_values['col1'] == 123
	assert reader.min_values['col2'] == 'abc'
	assert reader.max_values['col1'] == 123
	assert reader.max_values['col2'] == 'abc'

def test_process_line_updates_values():
	reader = tsv_reader()
	reader.headers = tuple(['col1', 'col2'])
	reader.process_line(('123','abc',))
	reader.process_line(('456','def',))
	assert reader.min_values['col1'] == 123
	assert reader.min_values['col2'] == 'abc'
	assert reader.max_values['col1'] == 456
	assert reader.max_values['col2'] == 'def'

def test_min_values_are_saved(reader):
	assert reader.min_values['Rank'] == 1
	assert reader.min_values['Country'] == 'Afghanistan'
	assert reader.min_values['Population'] == 54

def test_max_values_are_saved(reader):
	assert reader.max_values['Rank'] == 238
	assert reader.max_values['Country'] == 'Zimbabwe'
	assert reader.max_values['Population'] == 1373541278


