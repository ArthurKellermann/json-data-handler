package model.entities;

import java.lang.reflect.Type;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.exceptions.DomainException;

public class JsonReader {
	private Gson gson;

	public JsonReader() {
		gson = new Gson();
	}

	public JsonData readOneJson(String path) {
		try {
			if (!isPathValid(path)) {
				throw new DomainException("Invalid path");
			}

			String json = Files.readString(Paths.get(path), StandardCharsets.UTF_8);

			JsonData jd = gson.fromJson(json, JsonData.class);

			return jd;

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return null;
		} catch (DomainException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}

	public List<JsonData> readListJson(String path) {
		try {
			if (!isPathValid(path)) {
				throw new DomainException("Invalid path");
			}

			String json = Files.readString(Paths.get(path), StandardCharsets.UTF_8);

			Type listType = new TypeToken<List<JsonData>>() {
			}.getType();

			List<JsonData> people = new Gson().fromJson(json, listType);

			return people;

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return null;

		} catch (DomainException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return null;

		}
	}

	public boolean isPathValid(String path) {
		Path file = Paths.get(path);
		return Files.exists(file) && Files.isRegularFile(file) && path.endsWith(".json");
	}
}
