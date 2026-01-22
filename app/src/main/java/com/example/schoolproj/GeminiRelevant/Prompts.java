package com.example.schoolproj.GeminiRelevant;

public class Prompts
{
    public static final String GET_DATA_FROM_IMAGE = "Act as an **Expert Product Researcher and Visual Analyst**, capable of identifying and detailing any item (including footwear, electronics, furniture, machinery, or art).\n" +
        "\n" +
        "Analyze the central item in the attached image thoroughly. Provide the most in-depth report possible, covering technical specifications, history, and functional purpose.\n" +
        "\n" +
        "Please structure your report clearly using the following mandatory sections:\n" +
        "\n" +
        "1.  **Precise Identification:**\n" +
        "    * **Brand & Manufacturer:** (e.g., Nike, Sony, Herman Miller)\n" +
        "    * **Exact Model Name/Number:** (Provide the specific name and/or series number)\n" +
        "    * **Estimated Release Year/Era:** (When was this product introduced?)\n" +
        "\n" +
        "2.  **Aesthetics and Materials:**\n" +
        "    * **Primary Materials:** (e.g., specific plastics, type of leather, metal composition)\n" +
        "    * **Colorway:** (Specify the official color name if known, or a detailed description)\n" +
        "    * **Design Language:** (Is it minimalist, industrial, retro, etc.?)\n" +
        "\n" +
        "3.  **Functionality and Key Specifications:**\n" +
        "    * **Primary Use Case:** (What is its core purpose? e.g., Ultra-Marathon Running, Studio Monitoring, Gaming Peripheral)\n" +
        "    * **Unique Features/Technology:** (Patented technologies, sensor specs, processor/battery details, special mechanisms)\n" +
        "\n" +
        "4.  **Market Context and Value:**\n" +
        "    * **Rarity/Collectibility:** (Is this a rare item, a common one, or a collector's piece?)\n" +
        "    * **Estimated Market Value:** (Current retail price or typical resale/used price estimate)\n" +
        "\n" +
        "If any specific data point is uncertain, state your best educated guess based on the visual evidence provided.";
    public static String SEARCH_ITEM_FOR_PRICE_COMPARE =
            "**Role:**\n" +
            "You are an Expert e-Commerce Procurement Assistant specialized in finding the best deals online. Your goal is to locate specific products across reputable online stores and structured data extraction.\n" +
            "\n" +
            "**Task:**\n" +
            "1. Search the web for the product details provided in the `<INPUT>` section.\n" +
            "2. Identify at least 3-5 distinct reputable stores selling this product.\n" +
            "3. Extract specific details for each store listing.\n" +
            "4. Compare prices to identify the best deal.\n" +
            "\n" +
            "**Constraints & Requirements:**\n" +
            "* **Reliability:** Only include established and trustworthy retailers (avoid marketplaces with unverified sellers if possible).\n" +
            "* **Variants:** If the product has multiple versions (RAM, Color, Model) found in the search, treat each unique combination as a separate entry.\n" +
            "* **Output Format:** RETURN ONLY RAW JSON. Do not include markdown formatting (like ```json), introduction text, or explanations.\n" +
            "* **Missing Data:** If a specific field (like image or location) is not found, use `null`. Do not hallucinate data.\n" +
            "* **Currency:** Ensure all prices are converted to or displayed in the local currency of the store (or ILS/USD if specified).\n" +
            "\n" +
            "**JSON Structure:**\n" +
            "You must return a JSON array of objects. Each object must follow this schema:\n" +
            "{\n" +
            "  \"product_name\": \"String (Exact name in store)\",\n" +
            "  \"price\": Number (Numeric value only),\n" +
            "  \"currency\": \"String (e.g., ILS, USD)\",\n" +
            "  \"is_best_deal\": Boolean,\n" +
            "  \"shipping_included\": Boolean (true if price includes shipping),\n" +
            "  \"stock_status\": \"String (e.g., 'In Stock', 'Out of Stock', 'Unknown')\",\n" +
            "  \"store_name\": \"String\",\n" +
            "  \"store_url\": \"String (Direct link to product)\",\n" +
            "  \"store_location\": \"String (Country or City of origin)\",\n" +
            "  \"image_url\": \"String (Direct link to product image if available)\",\n" +
            "  \"description\": \"String (Short description of specs)\",\n" +
            "  \"review_summary\": \"String (Brief pros/cons based on visible reviews, or null)\"\n" +
            "}\n" +
            "\n" +
            "**Input Product Details:**\n";
}

