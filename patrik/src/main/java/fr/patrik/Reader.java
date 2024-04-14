package fr.patrik;

public class Reader {
    private FileSystemReader fileReader;
	private JdbcReader jdbcReader;

    public FileSystemReader getFileReader() {
		return this.fileReader;
	}

	public void setFileReader(FileSystemReader fileReader) {
		this.fileReader = fileReader;
	}

    public JdbcReader getJdbcReader() {
		return this.jdbcReader;
	}

	public void setJdbcReader(JdbcReader jdbcReader) {
		this.jdbcReader = jdbcReader;
	}
}
