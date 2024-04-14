package fr.patrik;

public class Reader {
    private FileSystemReader fileReader;
	private JdbcReader jdbcReader;
	private String url;
	private String username;
	private String password;

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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
